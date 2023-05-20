package earth.defense.corps.edc.domain.stage.model;

public enum StagePhase {

    PHASE_ONE(1),
    PHASE_TWO(2),
    PHASE_THREE(3);

    final int phase;

    StagePhase(int phase){
        this.phase = phase;
    }

    public int getEnumPhase(){
        return phase;
    }

    public static StagePhase getPhaseByInt(int phase){
        for(StagePhase stagePhase: StagePhase.values()){
            if(stagePhase.phase == phase){
                return stagePhase;
            }
        }
        return null;
    }
}