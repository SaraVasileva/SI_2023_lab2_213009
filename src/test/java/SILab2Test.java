import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SILab2Test {
    public List<User> createList(User... users){
        return new ArrayList<>(Arrays.asList(users));
    }
    // EVERY BRANCH
    @Test
    void Test1()
    {
        User user=new User("user123",null,"user123@yahoo.com");
        List<User> allUsers=createList(new User("user1", "password1", "user1@gmail.com"));
        RuntimeException ex;
        ex=assertThrows(RuntimeException.class,() -> SILab2.function(user,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

    }
    @Test
    void Test2() {
        User user = new User("", "pass123", "user123@yahoo.com");
        List<User> allUsers=createList();
        assertFalse(SILab2.function(user, allUsers));

    }
    @Test
    void Test3() {

        User user = new User("username", "password 123", "user123@gmail.com");
        List<User> allUsers=createList(
                new User("username", "password1", "user123@gmail.com") ,
                new User("user","password2", "user2@gmail.com" ));
        assertFalse(SILab2.function(user, allUsers));
    }

    @Test //4
    void Test4() {
        User user = new User("username", "Password123!!", "badEmail");
        List<User> allUsers = createList(new User("user1", "password1", "user1@gmail.com"));

        assertFalse(SILab2.function(user, allUsers));
    }

    // MULTIPLE CONDITION
    @Test
    void TestMultipleCon ()
    {
        // F F F
        User user=new User("username","password","user1@gmail.com");
        List<User> allUsers=createList();
        RuntimeException ex;
        assertDoesNotThrow(() -> SILab2.function(user,allUsers));

        // T X X
        User user1=new User(null,"password",null);
        ex=assertThrows(RuntimeException.class,() -> SILab2.function(user1,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //F T X
        User user2=new User("username",null,"email.com");
        ex=assertThrows(RuntimeException.class,() -> SILab2.function(user2,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // F F T
        User user3=new User("username","password",null);
        ex=assertThrows(RuntimeException.class,() -> SILab2.function(user3,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));


    }



}












