package test;

public class GenericClass<typeParameter>
{
    private final typeParameter para;

    public GenericClass(typeParameter parameter)
    {
        para = parameter;
    }

    public final void print()
    {
        System.out.println(para);
    }

    public static void main(String[] args)
    {
        GenericClass<String> variableName = new GenericClass<String>("blah");
        variableName.print();
    }
}
