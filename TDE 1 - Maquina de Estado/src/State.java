public interface State<C extends Character>{
    void enter();
    void execute();
    void exit();
    C getCharacter();
}
