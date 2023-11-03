package webg5.vscode;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("Test de Lombok");
        Position pos1 = new Position(1, 2);
        Position pos2 = new Position(1, 2);
        System.out.println(pos1);
        System.out.println(pos2);
        System.out.println(pos1.equals(pos2));
        System.out.println(pos1.getRow());
    }
}