public class Tamagotchi {
    private int energiaMax;
    private int energiaAtual;
    private int saciedadeMax;
    private int saciedadeAtual;
    private int limpezaMax;
    private int limpezaAtual;
    private int idadeMax;
    private int idadeAtual = 0;
    private int diamantes = 0;
    private boolean vivo = true;

    public Tamagotchi(int energiaMax, int saciedadeMax, int limpezaMax, int idadeMax){
        this.energiaMax = energiaMax;
        this.energiaAtual = energiaMax;
        this.saciedadeMax = saciedadeMax;
        this.saciedadeAtual = saciedadeMax;
        this.limpezaMax = limpezaMax;
        this.limpezaAtual = limpezaMax;
        this.idadeMax = idadeMax;
        System.out.print("Tamagoshi criado: ");
        mostra();
    }

    public int getEnergiaMax() {
        return energiaMax;
    }

    public int getSaciedadeMax() {
        return saciedadeMax;
    }

    public int getLimpezaMax() {
        return limpezaMax;
    }

    public int getIdadeMax() {
        return idadeMax;
    }

    public int getEnergiaAtual() {
        return energiaAtual;
    }

    public void setEnergiaAtual(int valor){
        if(energiaAtual + valor >= energiaMax){
            energiaAtual = energiaMax; 
        }else if(energiaAtual + valor <= 0){
            energiaAtual = 0;
            vivo = false;
        }else{
            energiaAtual += valor;
        }
        
    }

    public int getSaciedadeAtual() {
        return saciedadeAtual;
    }

    public void setSaciedadeAtual(int valor){
        if(saciedadeAtual + valor >= saciedadeMax){
            saciedadeAtual = saciedadeMax; 
        }else if(saciedadeAtual + valor <= 0){
            saciedadeAtual = 0;
            vivo = false;
        }else{
            saciedadeAtual += valor;
        }
    }

    public int getLimpezaAtual() {
        return limpezaAtual;
    }

    public void setLimpezaAtual(int valor){
        if(limpezaAtual + valor >= limpezaMax){
            limpezaAtual = limpezaMax; 
        }else if(limpezaAtual + valor <= 0){
            limpezaAtual = 0;
            vivo = false;
        }else{
            limpezaAtual += valor;
        }
    }

    public int getIdadeAtual() {
        return idadeAtual;
    }

    public void setIdadeAtual(int valor){
        if(idadeAtual + valor >= idadeMax){
            vivo = false;
            idadeAtual = idadeMax;
        }else{
            idadeAtual += valor;
        }
    }

    public int getDiamantes() {
        return diamantes;
    }
    
    public void setDiamantes(int valor){
        diamantes += valor;
    }

    public boolean getEstaVivo(){
        // if(vivo){
        //     System.out.println("vivo!");
        // }else{
        //     System.out.println("morto!");
        // }
        // mostra();
        return vivo;
    }

    public void morrendo(){
        vivo = false;
        System.out.println("morrendo...");
        mostra();
    }
    
    public boolean brincar(){
        if(!getEstaVivo()){
            System.out.println("morto não brinca!");
            mostra();
            return false;
        }else{
            setEnergiaAtual(-2);
            setSaciedadeAtual(-1);
            setLimpezaAtual(-3);
            setDiamantes(1);
            setIdadeAtual(1);
            System.out.println("brincou!");
            mostra();
        }
        return true;
    }

    public boolean comer(){
        if(!getEstaVivo()){
            System.out.println("morto não come!");
            mostra();
            return false;
        }else{
            setEnergiaAtual(-1);
            setSaciedadeAtual(4);
            setLimpezaAtual(-2);
            setIdadeAtual(1);
            System.out.println("comeu!");
            mostra();
        }
        return true;
    }

    public boolean dormir(){
        if(!getEstaVivo() || energiaAtual >= energiaMax-4){
            System.out.println("Ou tá morto ou não gastou ainda 5 pontos de energia!");
            mostra();
            return false;
        }else{
            while(energiaAtual != energiaMax){
                setEnergiaAtual(1);
                setIdadeAtual(1);
            }
            setSaciedadeAtual(-2);
            System.out.println("dormiu");
            mostra();
            return true;
        }
        
    }

    public boolean banhar(){
        if(!getEstaVivo()){
            System.out.println("morto não toma banho!");
            mostra();
            return false;
        }else{
            setEnergiaAtual(-3);
            setSaciedadeAtual(-1);
            setLimpezaAtual(limpezaMax);
            setIdadeAtual(2);
            System.out.println("tomou banho!");
            mostra();
        }
        return true;
    }

    public void mostra(){
        System.out.println("E:" + getEnergiaAtual() + "/" + getEnergiaMax() +
                ", S:" + getSaciedadeAtual() + "/" + getSaciedadeMax() + 
                ", L:" + getLimpezaAtual() + "/" + getLimpezaMax() +
                ", D:" + getDiamantes() + 
                ", I:" + getIdadeAtual() + "/" + getIdadeMax() +
                ", Vv: " + vivo);

    }
}
