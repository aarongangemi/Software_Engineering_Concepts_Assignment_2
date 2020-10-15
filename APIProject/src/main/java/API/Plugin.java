package API;
public interface Plugin
{
    void start(API api);
    void setName(String name);
    String getName();
    
}