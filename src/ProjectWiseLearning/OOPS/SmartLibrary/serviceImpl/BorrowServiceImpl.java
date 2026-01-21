package ProjectWiseLearning.OOPS.SmartLibrary.serviceImpl;

import ProjectWiseLearning.OOPS.SmartLibrary.model.Book;
import ProjectWiseLearning.OOPS.SmartLibrary.model.Member;
import ProjectWiseLearning.OOPS.SmartLibrary.service.BorrowService;

public class BorrowServiceImpl implements BorrowService {

    @Override
    public void borrowBook(Member member, Book book) {
        System.out.println(member.getRole() + " borrowed " + book.title);
    }


}

