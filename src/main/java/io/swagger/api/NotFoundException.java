package java.io.swagger.api;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-01-16T11:52:43.332412975Z[GMT]")
public class NotFoundException extends ApiException
{
    private int code;
    public NotFoundException (int code, String msg)
    {
        super(code, msg);
        this.code = code;
    }
}
