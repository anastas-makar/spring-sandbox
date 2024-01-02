package pro.progr.restful;

public interface GreetingRepository {
    Greeting save(String content);
    Greeting findById(long id);
}
