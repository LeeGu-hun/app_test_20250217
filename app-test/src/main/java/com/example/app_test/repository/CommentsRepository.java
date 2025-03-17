package com.example.app_test.repository;

import com.example.app_test.entity.Comments;
import com.example.app_test.entity.Journal;
import com.example.app_test.entity.Members;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

  @EntityGraph(attributePaths = {"members"}, type = EntityGraph.EntityGraphType.FETCH)
  List<Comments> findByJournal(Journal journal);

  @Modifying
  @Query("delete from Comments c where c.members = :members")
  void deleteByMembers(Members members);

  @Modifying
  @Query("delete from Comments c where c.journal.jno = :jno ")
  void deleteByJno(@Param("jno") Long jno);

}
