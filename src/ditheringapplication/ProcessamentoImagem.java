package ditheringapplication;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author rogerio
 */
public class ProcessamentoImagem {
    
    public ImageIcon imagemCarregada;
    public BufferedImage imagemTemporaria;
    public javax.swing.JFileChooser selecionadorImagem;
    public javax.swing.JLabel labelImagem;
    
    public ProcessamentoImagem(javax.swing.JFileChooser selecionadorImagem,
            javax.swing.JLabel labelImagem,
            ImageIcon imagemCarregada){
        
        this.selecionadorImagem = selecionadorImagem;
        this.labelImagem = labelImagem;
        this.imagemCarregada = imagemCarregada;
        
    }
    
    public void setImagemCarregada(ImageIcon imagemCarregada){
        
        this.imagemCarregada = imagemCarregada;        
    }     

    public void quantizaImagem(String tipoProcessamento){
                    
        BufferedImage imagemLida = null;              
        
        try {
            imagemLida = ImageIO.read(
                    selecionadorImagem.getSelectedFile());
            imagemTemporaria = new BufferedImage(imagemLida.getWidth(), 
                    imagemLida.getHeight(),BufferedImage.TYPE_INT_ARGB);                        
            
        } catch (IOException ex) {
            Logger.getLogger("Não encontrou a imagem: " +
                    selecionadorImagem.getSelectedFile().getAbsolutePath());
        }
                
        //aqui seleciona o quantizador
        if(tipoProcessamento.equals( "imagemOriginalBotao")){
            
            labelImagem.setIcon(imagemCarregada);
                   
        }else if(tipoProcessamento.equals("Cinza1bitBotao")){
            
           QuantizadoresProcessadores processa1bitCinza = new Processa1bitCinza();               
            coresProcessadas(imagemLida, processa1bitCinza);
            
        }else if(tipoProcessamento.equals("Cinza2bitBotao")){
            
            QuantizadoresProcessadores processa2bitCinza = new Processa2bitCinza();            
            coresProcessadas(imagemLida, processa2bitCinza);
            
        }else if(tipoProcessamento.equals("CMYK1bitBotao")){
            
            QuantizadoresProcessadores processa1bitCMYK = new Processa1bitCMYK();            
            coresProcessadas(imagemLida, processa1bitCMYK);
            
        }else if(tipoProcessamento.equals("CMYK2bitBotao")){
            
            QuantizadoresProcessadores processa2bitCMYK = new Processa2bitCMYK();            
            coresProcessadas(imagemLida, processa2bitCMYK);
            
        }else if(tipoProcessamento.equals("RGB1bitBotao")){
            
            QuantizadoresProcessadores rGB1bitBotao = new ProcessaRGB1bitBotao();            
            coresProcessadas(imagemLida, rGB1bitBotao);
            
        }else if(tipoProcessamento.equals("RGB2bitBotao")){
            
            QuantizadoresProcessadores rGB2bitBotao = new ProcessaRGB2bitBotao();            
            coresProcessadas(imagemLida, rGB2bitBotao);
            
        }else if(tipoProcessamento.equals("coresTabelaVerde")){
            
            QuantizadoresProcessadores processaCoresTabelaVerde = 
                    new ProcessaCoresTabelaVerde();            
            coresProcessadas(imagemLida, processaCoresTabelaVerde);
            
        }else if(tipoProcessamento.equals("coresGameBoyBotao")){
            
            QuantizadoresProcessadores processaCoresGameBoy = new ProcessaCoresGameBoy();            
            coresProcessadas(imagemLida, processaCoresGameBoy);
            
        }        
    }
    
    public void processaDithering(String tipoProcessamento){
        
        BufferedImage imagemLida = null;              
                
        int corValorInteiro = 0;
        int  vermelho = 0;
        int  verde = 0;
        int  azul = 0;
         
        //cores[0] é a cor alfa
        //cores[1] é a cor vermelho
        //cores[2] é a cor verde
        //cores[3] é a cor azul
        int[] cores = null;
        //coloque mai um zer {0} só para facilitar a leitura
        int[] erroDeQuantificaao = {0, 0, 0, 0};
        int coresProcessadas = 0;
        QuantizadoresProcessadores processamentoEscolido = new Processa1bitCinza();
        
        try {
            imagemLida = ImageIO.read(
                    selecionadorImagem.getSelectedFile());
            imagemTemporaria = new BufferedImage(imagemLida.getWidth(), 
                    imagemLida.getHeight(),BufferedImage.TYPE_INT_ARGB);                        
            
        } catch (IOException ex) {
            Logger.getLogger("Não encontrou a imagem: " +
                    selecionadorImagem.getSelectedFile().getAbsolutePath());
        }
        
        if(tipoProcessamento.equals("Cinza1bitBotao")){
            
           processamentoEscolido = new Processa1bitCinza();
            
        }else if(tipoProcessamento.equals("Cinza2bitBotao")){
            
            processamentoEscolido = new Processa2bitCinza();
            
        }else if(tipoProcessamento.equals("CMYK1bitBotao")){
            
            processamentoEscolido = new Processa1bitCMYK();
            
        }else if(tipoProcessamento.equals("CMYK2bitBotao")){
            
            processamentoEscolido = new Processa2bitCMYK();
                        
        }else if(tipoProcessamento.equals("RGB1bitBotao")){
            
            processamentoEscolido = new ProcessaRGB1bitBotao();           
            
        }else if(tipoProcessamento.equals("RGB2bitBotao")){
            
            processamentoEscolido = new ProcessaRGB2bitBotao();            
            
        }else if(tipoProcessamento.equals("coresTabelaVerde")){
            
            processamentoEscolido = new ProcessaCoresTabelaVerde();
            
        }else if(tipoProcessamento.equals("coresGameBoyBotao")){
            
            processamentoEscolido = new Processa2bitCinza();            
        }         

        float setePorDezeseis = 0.4375f;//0.4375f;
        float tresPorDezeseis = 0.1875f;//0.1875f
        float cincoPorDezeseis = 0.3125f;//0.3125f
        float umPorDezeseis = 0.0625f;//0.0625f
        
        int[][][] valoresTemporariosDeCoresDosPixels = new int[imagemLida.getWidth()]
                [imagemLida.getHeight()][4];
        
        //Passa as cores para o array de processamento
        for (int y = 1; y < imagemLida.getHeight(); y++){
            
            for (int x = 1; x < imagemLida.getWidth(); x++){
                
                corValorInteiro = imagemLida.getRGB(x, y);
                            
                vermelho = (corValorInteiro & 0x00ff0000) >> 16;
                verde = (corValorInteiro & 0x0000ff00) >> 8;
                azul = corValorInteiro & 0x000000ff;

                valoresTemporariosDeCoresDosPixels[x][y][0] = 255;
                valoresTemporariosDeCoresDosPixels[x][y][1] = vermelho;
                valoresTemporariosDeCoresDosPixels[x][y][2] = verde;
                valoresTemporariosDeCoresDosPixels[x][y][3] = azul;
            }
        }
        
        for (int y = 1; y < imagemLida.getHeight(); y++){
            
            for (int x = 1; x < imagemLida.getWidth(); x++){
     
                cores = processamentoEscolido.processaCores(
                        valoresTemporariosDeCoresDosPixels[x][y][1], 
                        valoresTemporariosDeCoresDosPixels[x][y][2], 
                        valoresTemporariosDeCoresDosPixels[x][y][3]);

                erroDeQuantificaao[1] = 
                        valoresTemporariosDeCoresDosPixels[x][y][1] -  cores[1];
                erroDeQuantificaao[2] = 
                        valoresTemporariosDeCoresDosPixels[x][y][2] -  cores[2];
                erroDeQuantificaao[3] = 
                        valoresTemporariosDeCoresDosPixels[x][y][3] -  cores[3];

                //aqui coloca os valores processados no
                //array original
                valoresTemporariosDeCoresDosPixels[x][y] = cores;

                //seta os pixels ao redor                   
                if((x < (imagemLida.getWidth()-1)) &&
                        (y < (imagemLida.getHeight()-1))){  
                    calculaErroPixel(valoresTemporariosDeCoresDosPixels, (x + 1), 
                        y, erroDeQuantificaao, setePorDezeseis );
                    if(x != 1){                        
                    calculaErroPixel(valoresTemporariosDeCoresDosPixels, 
                            (x - 1), (y + 1), 
                            erroDeQuantificaao, tresPorDezeseis );

                    }

                     calculaErroPixel(valoresTemporariosDeCoresDosPixels, x, 
                       (y + 1), erroDeQuantificaao, cincoPorDezeseis );

                    calculaErroPixel(valoresTemporariosDeCoresDosPixels, (x + 1), 
                       (y + 1), erroDeQuantificaao, umPorDezeseis );                        
                }                       
            }
        }
        
        if(tipoProcessamento.equals("coresGameBoyBotao")){
            
            processamentoEscolido = new ProcessaCoresGameBoy();
            int[] coresGameBoy;
            //Conver cinza2bit para cores do Game Boy
            for (int y = 1; y < imagemLida.getHeight(); y++){

                for (int x = 1; x < imagemLida.getWidth(); x++){

                    coresGameBoy = processamentoEscolido.processaCores(
                            valoresTemporariosDeCoresDosPixels[x][y][1], 
                            valoresTemporariosDeCoresDosPixels[x][y][2], 
                            valoresTemporariosDeCoresDosPixels[x][y][3]);
                    
                    //converter cores para valor unico
                    coresProcessadas = (
                            coresGameBoy[0]<<24) | 
                            (coresGameBoy[1]<<16) | 
                            (coresGameBoy[2]<<8) | 
                            coresGameBoy[3]; 

                    imagemTemporaria.setRGB(x, y,coresProcessadas );

                }
            } 
            
        } else{
            
            //Coloca as cores prossesadas na imagem
            for (int y = 1; y < imagemLida.getHeight(); y++){

                for (int x = 1; x < imagemLida.getWidth(); x++){

                    //converter cores para valor unico
                    coresProcessadas = (
                            valoresTemporariosDeCoresDosPixels[x][y][0]<<24) | 
                            (valoresTemporariosDeCoresDosPixels[x][y][1]<<16) | 
                            (valoresTemporariosDeCoresDosPixels[x][y][2]<<8) | 
                            valoresTemporariosDeCoresDosPixels[x][y][3]; 

                    imagemTemporaria.setRGB(x, y,coresProcessadas );

                }
            }             
        }
                    
        labelImagem.setIcon(new ImageIcon(imagemTemporaria));        
    }

    public void calculaErroPixel(int[][][] valoresDeErroDosPixels
              , int x, int y,int[] erro, float variavelDeErro){

        valoresDeErroDosPixels[x][y][1] = (valoresDeErroDosPixels[x][y][1] + 
                (Math.round(erro[1] * variavelDeErro)));
        valoresDeErroDosPixels[x][y][2] = (valoresDeErroDosPixels[x][y][2] + 
                (Math.round(erro[2] * variavelDeErro)));
        valoresDeErroDosPixels[x][y][3] = (valoresDeErroDosPixels[x][y][3] + 
                (Math.round(erro[3] * variavelDeErro)));   
    }
    
    public void coresProcessadas(BufferedImage imagemLida,
            QuantizadoresProcessadores chamarMethodo){
        
        int corValorInteiro = 0;
        int vermelho = 0;
        int verde = 0;
        int azul = 0;
        int[] cores = {0};
        int coresProcessadas = 0; 
        
        for (int y = 1; y < imagemLida.getHeight(); y++){
            
            for (int x = 1; x < imagemLida.getWidth(); x++){ 

                corValorInteiro = imagemLida.getRGB(x, y);

                vermelho = (corValorInteiro & 0x00ff0000) >> 16;
                verde = (corValorInteiro & 0x0000ff00) >> 8;
                azul = corValorInteiro & 0x000000ff;

                cores = chamarMethodo.processaCores(vermelho, verde, azul);

                //converter cores para valo unico
                coresProcessadas = (cores[0]<<24) | (cores[1]<<16) | 
                        (cores[2]<<8) | cores[3];  

                imagemTemporaria.setRGB(x, y,coresProcessadas );
            }
        }
        
        labelImagem.setIcon(new ImageIcon(imagemTemporaria));        
    }    
    
        
    
    //interface ----------------------------------------------------------------
    interface QuantizadoresProcessadores{
        
          public int[] processaCores(int vermelho, int verde, int azul );  
    }
    
    public class Processa1bitCinza implements QuantizadoresProcessadores{

        @Override
        public int[] processaCores(int vermelho, int verde, int azul) {
            
            int[] cores = {255, 0, 0, 0};
            
            if(((vermelho + verde + azul) / 3) < 128 ){

                return cores;

            }else{
                
                cores[1] = 255;
                cores[2] = 255;
                cores[3] = 255;
                return cores;
            }            
        }
    }
    
    public class Processa2bitCinza implements QuantizadoresProcessadores{

        @Override
        public int[] processaCores(int vermelho, int verde, int azul) {

            int corProcessada = processa2bit(
                    (vermelho + verde + azul) / 3);
            
            int[] cores = {255, corProcessada, corProcessada, corProcessada};

            return cores; 
        }
        
        public int processa2bit(int valorCor){

            if(valorCor < 32 ){

                return 0;

            }else if((valorCor >= 32) &&
                    (valorCor < 128)){

                return 85;

            }else if((valorCor >= 128) &&
                    (valorCor < 223) ){

                return 170;

            }else{

                return 255;
            }
        }             
    }
    
    public class Processa1bitCMYK implements QuantizadoresProcessadores{

        @Override
        @SuppressWarnings("empty-statement")
        public int[] processaCores(int vermelho, int verde, int azul) {
            
            int[] cores = {255,0,0,0}; 
                        
            int amarelo = (vermelho + verde) / 2;
            int magenta = (vermelho + azul) / 2;
            int ciano = (verde + azul) / 2;
            
            if(((vermelho + verde + azul) / 3) >= 223){
                
                cores[1] = 255;
                cores[2] = 255;
                cores[3] = 255;
                return cores; 
                
            }else{
                
                if(amarelo >= 128){ 

                    cores[1] = 255;
                    cores[2] = 255;
                    //cores[3] = 0;

                }
                if(magenta >= 128){ 

                    cores[1] = 255;
                    //cores[2] = 0;
                    cores[3] = 255;

                }
                if(ciano >= 128){ 

                    //cores[1] = 0;
                    cores[2] = 255;
                    cores[3] = 255;

                }
                     
                return cores; 
            }    
        }
    }
    
    public class Processa2bitCMYK implements QuantizadoresProcessadores{

        @Override
        @SuppressWarnings("empty-statement")
        public int[] processaCores(int vermelho, int verde, int azul) {
            
            int[] cores = {255,0,0,0}; 
            
            int amarelo = Math.round((vermelho + verde) / 4);
            int magenta = Math.round((vermelho + azul) / 4);
            int ciano = Math.round((verde + azul) / 4);

            cores[1] = processa2bit(amarelo + magenta);
            cores[2] = processa2bit(ciano + amarelo);
            cores[3] = processa2bit(ciano + magenta);
            
            return cores;
        }
        
        public int processa2bit(int valorCor){

            if(valorCor < 32 ){

                return 0;

            }else if((valorCor >= 32) &&
                    (valorCor < 128)){

                return 85;

            }else if((valorCor >= 128) &&
                    (valorCor < 223) ){

                return 170;

            }else{

                return 255;
            }
        }
    }
    
    public class ProcessaRGB1bitBotao implements QuantizadoresProcessadores{

        @Override
        public int[] processaCores(int vermelho,  int verde, int azul) {
            
            int[] cores = {255,0,0,0}; 

            
            if(((vermelho + verde + azul) / 3) >= 223){
                
                cores[1] = 255;
                cores[2] = 255;
                cores[3] = 255;
                return cores; 
                
            }else{
                if(vermelho >= 128){ 

                    cores[1] = 255;
                    //cores[2] = 0;
                    //cores[3] = 0;/

                } 
                if(verde >= 128) { 

                    //cores[1] = 0;
                    cores[2] = 255;
                    //cores[3] = 0;/

                } 
                 if(azul >= 128){ 

                    //cores[1] = 0;
                    //cores[2] = 0;
                    cores[3] = 255;
                    
                }

                return cores; 
            }
        }
    }
    
    public class ProcessaRGB2bitBotao implements QuantizadoresProcessadores{

        @Override
        public int[] processaCores(int vermelho,  int verde, int azul) {
            
            int[] cores = {255,0,0,0}; 
                
            cores[1] = processa2bit(vermelho);
            cores[2] = processa2bit(verde);
            cores[3] = processa2bit(azul);
            return cores;
        }
        
        public int processa2bit(int valorCor){

            if(valorCor < 32 ){

                return 0;

            }else if((valorCor >= 32) &&
                    (valorCor < 128)){

                return 85;

            }else if((valorCor >= 128) &&
                    (valorCor < 223) ){

                return 170;

            }else{

                return 255;
            }
        }
    }
    
    public class ProcessaCoresGameBoy implements QuantizadoresProcessadores{

        @Override
        public int[] processaCores(int vermelho, int verde, int azul) {
            
            return processa2bit((vermelho + verde + azul) / 3);
            
        }
        
        public int[] processa2bit(int valorCor){

            int[] cores = {255, 0, 0, 0};

            if(valorCor < 32 ){

                cores[1] = 15;
                cores[2] = 56;
                cores[3] = 15;
                return cores;

            }else if((valorCor >= 32) &&
                    (valorCor < 128)){

                cores[1] = 48;
                cores[2] = 98;
                cores[3] = 25;
                return cores;

            }else if((valorCor >= 128) &&
                    (valorCor < 223) ){

                cores[1] = 139;
                cores[2] = 172;
                cores[3] = 35;
                return cores;

            }else{

                cores[1] = 190;
                cores[2] = 223;
                cores[3] = 45;
                return cores;

            }           
        }        
    }
    
        public class ProcessaCoresTabelaVerde implements QuantizadoresProcessadores{

        @Override
        public int[] processaCores(int vermelho, int verde, int azul) {
            
            return processa2bit((vermelho + verde + azul) / 3);            
        }
        
        public int[] processa2bit(int valorCor){

            int[] cores = {255, 0, 0, 0};

            
            if(valorCor < 20 ){

                cores[1] = 0;
                cores[2] = 25;
                cores[3] = 0;
                return cores;

            }else if((valorCor >= 20) &&
                    (valorCor < 50)){

                cores[1] = 15;
                cores[2] = 56;
                cores[3] = 15;
                return cores;

            }else if((valorCor >= 50) &&
                    (valorCor < 92)){

                cores[1] = 48;
                cores[2] = 98;
                cores[3] = 30;
                return cores;

            }else if((valorCor >= 92) &&
                    (valorCor < 140) ){

                cores[1] = 139;
                cores[2] = 190;
                cores[3] = 50;
                return cores;

            }else if((valorCor >= 140) &&
                    (valorCor < 223) ){

                cores[1] = 190;
                cores[2] = 235;
                cores[3] = 96;
                return cores;

            }else{

                cores[1] = 239;
                cores[2] = 255;
                cores[3] = 223;
                return cores;
            }            
        }        
    }    
}
