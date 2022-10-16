import java.io.IOException;

public abstract class pf_Filter {
    protected pf_Pipe input;
    protected pf_Pipe output;

    public pf_Filter(pf_Pipe input, pf_Pipe output) {
        this.input = input;
        this.output = output;
    }
    protected abstract void transform() throws IOException;
}
