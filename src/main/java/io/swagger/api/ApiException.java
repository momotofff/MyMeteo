package java.io.swagger.api;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-01-16T11:52:43.332412975Z[GMT]")
public class ApiException extends Exception
{
    private int code;
    public ApiException (int code, String msg)
    {
        super(msg);
        this.code = code;
    }
}
