/*
 * package com.stackroute.newsapp.repository;
 * 
 * import static org.assertj.core.api.Assertions.assertThat; import static
 * org.junit.Assert.assertEquals;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
 * import
 * org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.
 * Replace; import
 * org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest; import
 * org.springframework.test.context.junit4.SpringRunner; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * import com.stackroute.newsapp.domain.News;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @DataJpaTest
 * 
 * @AutoConfigureTestDatabase(replace=Replace.NONE)
 * 
 * @Transactional public class NewsRepoTest {
 * 
 * @Autowired private NewsRepository newsRepository;
 * 
 * public NewsRepository getNewsRepository() { return newsRepository; }
 * 
 * public void setNewsRepository(NewsRepository newsRepository) {
 * this.newsRepository = newsRepository; }
 * 
 * 
 * @Test public void testSaveNews()throws Exception { final News saveNews =
 * newsRepository.save(new News("Ladies stepped into Sabarimala on January 2",
 * "Hindu","Hoby","Ladies stepped into sabarimala","2019-01-01"));
 * 
 * final News news = newsRepository.getOne(saveNews.getId());
 * assertThat(news.getId()).isEqualTo(saveNews.getId()); }
 * 
 * @Test public void testUpdateNews() throws Exception{ final News saveNews =
 * newsRepository.save(new News("Ladies stepped into Sabarimala on January 2",
 * "Hindu","Hoby","Ladies stepped into sabarimala","2019-01-01")); final News
 * news = newsRepository.getOne(saveNews.getId());
 * assertEquals(news.getTitle(),"Ladies stepped into sabarimala");
 * news.setTitle("hi"); newsRepository.save(news); News tempnews =
 * newsRepository.getOne(saveNews.getId());
 * assertEquals("hi",tempnews.getTitle());
 * 
 * }
 * 
 * @Test public void testDeleteNews() throws Exception{ final News saveNews =
 * newsRepository.save(new News("Ladies stepped into Sabarimala on January 2",
 * "Hindu","Hoby","Ladies stepped into sabarimala","2019-01-01")); final News
 * news = newsRepository.getOne(saveNews.getId());
 * assertEquals(news.getTitle(),"Ladies stepped into sabarimala");
 * newsRepository.delete(news); //
 * assertEquals(Optional.empty(),newsRepository.findById(1)); }
 * 
 * @Test public void testGetNews() throws Exception{ final News saveNews =
 * newsRepository.save(new News("Ladies stepped into Sabarimala on January 2",
 * "Hindu","Hoby","Ladies stepped into sabarimala","2019-01-01")); final News
 * news = newsRepository.getOne(saveNews.getId());
 * assertEquals(news.getTitle(),"Ladies stepped into sabarimala"); }
 * 
 * @Test public void testGetAllMyMovies() throws Exception{
 * newsRepository.save(new News("Ladies stepped into Sabarimala on January 2",
 * "Hindu","Hoby","Ladies stepped into sabarimala","2019-01-01"));
 * newsRepository.save(new News("John Brito passed away",
 * "Hindu","Hoby","John Brito passed away","2019-01-02")); final List<News> news
 * = newsRepository.findAll();
 * assertEquals(news.get(0).getTitle(),"Ladies stepped into sabarimala"); }
 * 
 * 
 * }
 */