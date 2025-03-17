package com.example.app_test.repository;

import com.example.app_test.entity.Comments;
import com.example.app_test.entity.Journal;
import com.example.app_test.entity.Members;
import com.example.app_test.entity.Photos;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

@SpringBootTest
class CommentsRepositoryTests {
  @Autowired
  CommentsRepository commentsRepository;

  @Autowired
  MembersRepository membersRepository;

  @Autowired
  JournalRepository journalRepository;

  @Test
  public void insertJournalComments() {
    IntStream.rangeClosed(1, 200).forEach(i -> {
      Long mid = (long) (Math.random() * 100) + 1;
      Long jno = (long) (Math.random() * 100) + 1;

      Comments comments = Comments.builder()
          .journal(Journal.builder().jno(jno).build())
          .members(Members.builder().mid(mid).build())
          .likes(Long.valueOf((int)(Math.random() * 2)))
          .text("이 글에 대하여..." + i)
          .build();
      commentsRepository.save(comments);
    });
  }

  @Test
  public void testGetJournalComments() {

  }

  @Transactional
  @Commit
  @Test
  public void testDeleteMembers() {

  }
}