package Labs.Lab6;

import static org.junit.jupiter.api.Assertions.*;

class GradebookTester {

  GradeBook test1;
  GradeBook test2;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    test1 = new GradeBook(5);
    test2 = new GradeBook(5);

    test1.addScore(75);
    test1.addScore(80);
    test1.addScore(93);
    test1.addScore(91);

    test2.addScore(67);
    test2.addScore(73);
    test2.addScore(59);
  }

  @org.junit.jupiter.api.AfterEach
  void tearDown() {
    test1 = null;
    test2 = null;
  }

  @org.junit.jupiter.api.Test
  void addScore() {
    assertTrue(test1.toString().equals("75.0 80.0 93.0 91.0 0.0 "));
    assertTrue(test2.toString().equals("67.0 73.0 59.0 0.0 0.0 "));
    assertEquals(4, test1.getScoresSize());
    assertEquals(3, test2.getScoresSize());
  }

  @org.junit.jupiter.api.Test
  void sum() {
    assertEquals(339, test1.sum());
    assertEquals(199, test2.sum());
  }

  @org.junit.jupiter.api.Test
  void minimum() {
    assertEquals(75, test1.minimum());
    assertEquals(59, test2.minimum());
  }

  @org.junit.jupiter.api.Test
  void finalScore() {
    assertEquals(264, test1.finalScore());
    assertEquals(140, test2.finalScore());
  }
}