package helloInterview.lld.stackOverflow.strategy;

import helloInterview.lld.stackOverflow.entities.Question;

import java.util.List;

public interface SearchStrategy {
    List<Question> filter(List<Question> questions);
}
