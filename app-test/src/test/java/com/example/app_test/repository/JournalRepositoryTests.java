package com.example.app_test.repository;

import com.example.app_test.entity.Journal;
import com.example.app_test.entity.Members;
import com.example.app_test.entity.Photos;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
class JournalRepositoryTests {
  @Autowired
  private JournalRepository journalRepository;
  @Autowired
  private PhotosRepository photosRepository;

  @Test
  @Transactional
  @Commit
  public void insertJournals() {
    IntStream.rangeClosed(1, 100).forEach(i -> {
      Journal journal = Journal.builder()
          .title("Title..." + i)
          .content("Content..." + i)
          .members(Members.builder().mid(Long.valueOf(i)).build())
          .build();
      journalRepository.save(journal);

      int count = (int) (Math.random() * 5) + 1;
      for (int j = 0; j < count; j++) {
        Photos photos = Photos.builder()
            .uuid(UUID.randomUUID().toString())
            .journal(journal)
            .photosName("photos" + j + ".jpg")
            .build();
        photosRepository.save(photos);
      }
    });
  }

  @Test
  public void testGetListPage() {

  }

  @Test
  public void testGetListPagePhotos() {

  }

  @Test
  public void testGetListPagePhotosJPQL() {

  }

  @Test
  public void testGetMaxQuery() {

  }

  @Test
  public void testGetJournalWithAll() {

  }


}