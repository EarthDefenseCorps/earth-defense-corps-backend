package earth.defense.corps.edc.domain.stage.model;

public enum StagePhase {

    PHASE_ONE("1"),
    PHASE_TWO("2"),
    PHASE_THREE("3");

    final String phase;

    StagePhase(String phase){
        this.phase = phase;
    }
}