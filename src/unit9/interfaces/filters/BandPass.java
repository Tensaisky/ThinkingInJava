package unit9.interfaces.filters;

public class BandPass extends Filter {
    double lowCutoff, highCutoff;
    public BandPass(double lowCut, double highCut){
        this.lowCutoff = lowCut;
        this.lowCutoff = highCut;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
