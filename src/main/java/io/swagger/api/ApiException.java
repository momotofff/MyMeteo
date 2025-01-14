package java.io.swagger.api;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-01-14T09:57:24.496581260Z[GMT]")
public class ApiException extends Exception
{
    private int code;
    public ApiException (int code, String msg)
    {
        super(msg);
        this.code = code;
    }
}
