# Втора лабораториска вежба по Софтверско инженерствo

## Сара Василева, 213009

### Control Flow Graph
![image](https://github.com/SaraVasileva/SI_2023_lab2_213009/assets/127666693/87448d95-6777-478a-a51c-5909790d8c4e)
### Цикломатска комплексност
Цикломатска комплексност на графот изнесува 11 и се пресметува така што се бројат предикантните јазли (Р) + 1. Предикантни јазли се јазлите кои се разгрануваат и на графот се обележани со светло сина боја. 

### Тест случаи според критериумот Every branch
За да го извршам Every branch тестирањето ми беа потребни 4 тестови.                                                                                                  
Сите можни гранки се:                                                                                                                                            
1,2 - 3    
3 - 28  
1,2 - 4  
4 - 5                                                        
5 - 6,7                                                       
4 - 6,7                                                       
6,7 – 8                                                                        
6,7 - 16                                                                        
8 - 9.1                                                                                                 
9.1 - 9.2                                                                               
9.2 - 10,11                                                                                                     
10,11 - 13                                                                                              
13 - 14                                                                                 
14 - 15                                                                                      
15 - 9.3                                                                                                          
9.3 - 9.2                                                                                                       
10,11 - 12                                                                                           
12 - 13                                                                                                                   
13 - 15                                                                                                   
9.2 - 16                                                                                              
16 - 17,18                                                                                                                            
17,18 - 20,21                                                                                             
20,21 - 26                                                                                      
26 - 27                                                                                                   
27 - 28                                                                                          
17,18 - 19                                                                                                 
19 - 27                                                                                        
20,21 - 22.1                                                                                                               
22.1 - 22.2                                                                                     
22.2 - 23                                                                                                               
23 - 25                                                                                                                        
25 - 22.3                                                                                                                  
22.3  - 22.2                                                                                                                                     
22.2 - 26                                                                                                                                
23 - 24                                                                                                              
24 – 25  
                                                                                                                               
public class SILab2Test {                                                                                                                                                                                                                                                                                  
    public List<User> createList(User... users){                                                                                                                                                                                                                                                         
        return new ArrayList<>(Arrays.asList(users)); }                                                                                                                                                          @Test                                                                                                                                                                                                                                                 
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

    @Test 
    void Test4() {
        User user = new User("username", "Password123!!", "badEmail");
        List<User> allUsers = createList(new User("user1", "password1", "user1@gmail.com"));

        assertFalse(SILab2.function(user, allUsers));
    }


### Тест случаи според критериумот Multiple Condition                                                                                      
#### if (user==null || user.getPassword()==null || user.getEmail()==null)
1) F F F
2) T X X
3) F T X
4) F F T        
  
  
   @Test                                                                                                                                                                                                
    void TestMultipleCon ()                                                                                                                           
    {
        User user=new User("username","password","user1@gmail.com");                                                                      
        List<User> allUsers=createList();                                                                                               
        RuntimeException ex;                                                                                                   
        assertDoesNotThrow(() -> SILab2.function(user,allUsers));                                                                            

       
        User user1=new User(null,"password",null);
        ex=assertThrows(RuntimeException.class,() -> SILab2.function(user1,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

       
        User user2=new User("username",null,"email.com");
        ex=assertThrows(RuntimeException.class,() -> SILab2.function(user2,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));


        User user3=new User("username","password",null);
        ex=assertThrows(RuntimeException.class,() -> SILab2.function(user3,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
    }


### Објаснување на напишаните Unit Tests                                                                                      
Еvery Branch тестирањето треба да ги помине сите можни гранки во кодот.                                                                                              
Multiple Condition тестирањето ги проверува сите комбинации за даден if-услов кој содржи логички оператоти, т.е да биде исполнет или да не биде.                                           Tестирањето на Еvery Branch и Multiple Condition е напишано така што да се обезбеди целосна покриеност на патеките за извршување на кодот. Со напишаните тестови потврдуваме дека секое можно сценарио и точка на одлука во кодот се извршуваат правилно. Во тестовите користиме:                                                                                                    assertTrue - овој тест потврдува дека функцијата враќа true, доколку влезните аргументи се напишани како што треба,                                                                         assertFalse - овој тест потврдува дека функцијата враќа false, доколку влезните аргументи не се напишани како што треба,                                                                     assertThrow - овој тест потврдува дека функцијата прима не важечки влез, т.е фрла исклучок,                                                                                                  assertDoesNotThrow - овој тест потврдува дека кодот се извршува без да фрли исклучок.

