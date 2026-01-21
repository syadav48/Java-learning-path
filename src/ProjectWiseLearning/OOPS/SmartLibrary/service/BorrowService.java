package ProjectWiseLearning.OOPS.SmartLibrary.service;

import ProjectWiseLearning.OOPS.SmartLibrary.model.Book;
import ProjectWiseLearning.OOPS.SmartLibrary.model.Member;

public interface BorrowService {
    void borrowBook(Member member, Book book);
}

