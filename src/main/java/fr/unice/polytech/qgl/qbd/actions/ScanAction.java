package fr.unice.polytech.qgl.qbd.actions;

import fr.unice.polytech.qgl.qbd.results.ScanResult;

public class ScanAction extends Action {
    public ScanAction() {
        super(NAME.SCAN);
    }

    @Override
    public ScanResult createResult(String JSONResult) {
        return new ScanResult(this, JSONResult);
    }
}
