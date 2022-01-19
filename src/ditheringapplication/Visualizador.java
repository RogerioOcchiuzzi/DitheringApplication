package ditheringapplication;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author rogerio
 */
public class Visualizador extends javax.swing.JFrame {

    public ImageIcon imagemCarregada;
    public int alturaImagemCanonica;
    public BufferedImage imagemTemporaria;
    public int valorPadraoimagemSlider;
    
    
    public ProcessamentoImagem processamentoImagem;
    
    public Visualizador() {

        initComponents();

        valorPadraoimagemSlider = 4;
            
        processamentoImagem = new ProcessamentoImagem(selecionadorImagem,
            labelImagem, imagemCarregada);
                       
    }
    

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selecionadorImagem = new javax.swing.JFileChooser();
        Quantizadores = new javax.swing.ButtonGroup();
        SalvarArquivoFileChooser = new javax.swing.JFileChooser();
        painelFundo = new javax.swing.JPanel();
        quantizador = new javax.swing.JLabel();
        labelImagem = new javax.swing.JLabel();
        botaoAplicarDithering = new javax.swing.JButton();
        botaoSelecionarImagem = new javax.swing.JButton();
        botaoSalvarArquivo = new javax.swing.JButton();
        imagemOriginalBotao = new javax.swing.JRadioButton();
        Cinza1bitBotao = new javax.swing.JRadioButton();
        Cinza2bitBotao = new javax.swing.JRadioButton();
        CMYK1bitBotao = new javax.swing.JRadioButton();
        CMYK2bitBotao = new javax.swing.JRadioButton();
        RGB1bitBotao = new javax.swing.JRadioButton();
        RGB2bitBotao = new javax.swing.JRadioButton();
        coresTabelaVerdeBotao = new javax.swing.JRadioButton();
        CoresGameBoyBotao = new javax.swing.JRadioButton();
        imagemSlider = new javax.swing.JSlider();

        selecionadorImagem.setBackground(new java.awt.Color(255, 255, 255));
        selecionadorImagem.setCurrentDirectory(new java.io.File("C:\\Users\\rogerio\\Desktop"));
        selecionadorImagem.setDialogTitle("Selecionar Imagem");
        selecionadorImagem.setName("Selecionador de Arquivos"); // NOI18N
        selecionadorImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionadorImagemActionPerformed(evt);
            }
        });

        SalvarArquivoFileChooser.setBackground(new java.awt.Color(255, 255, 255));
        SalvarArquivoFileChooser.setCurrentDirectory(new java.io.File("C:\\Users\\rogerio\\Desktop"));
        SalvarArquivoFileChooser.setDialogTitle("Salvar Imagem");
        SalvarArquivoFileChooser.setSelectedFiles(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visualizador de Dithering");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        setForeground(new java.awt.Color(0, 0, 0));
        setLocation(new java.awt.Point(200, 100));
        setPreferredSize(new java.awt.Dimension(1200, 720));
        setSize(new java.awt.Dimension(1200, 720));

        painelFundo.setBackground(new java.awt.Color(255, 255, 255));
        painelFundo.setAutoscrolls(true);
        painelFundo.setMaximumSize(new java.awt.Dimension(1280, 720));
        painelFundo.setPreferredSize(new java.awt.Dimension(1280, 720));

        quantizador.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        quantizador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quantizador.setText("Quantizadores");
        quantizador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelImagem.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        labelImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImagem.setText("Imagem");
        labelImagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        labelImagem.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        botaoAplicarDithering.setText("<html>Aplicar<br>\nDithiring");
        botaoAplicarDithering.setActionCommand("AplicarDith");
        botaoAplicarDithering.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoAplicarDithering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAplicarDitheringActionPerformed(evt);
            }
        });

        botaoSelecionarImagem.setText("<html>Selecionar<br>Imagem");
        botaoSelecionarImagem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoSelecionarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSelecionarImagemActionPerformed(evt);
            }
        });

        botaoSalvarArquivo.setText("<html>Salvar <br> Imagem");
        botaoSalvarArquivo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoSalvarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarArquivoActionPerformed(evt);
            }
        });

        imagemOriginalBotao.setBackground(new java.awt.Color(255, 255, 255));
        Quantizadores.add(imagemOriginalBotao);
        imagemOriginalBotao.setSelected(true);
        imagemOriginalBotao.setText("Imagem original");
        imagemOriginalBotao.setMaximumSize(new java.awt.Dimension(116, 18));
        imagemOriginalBotao.setMinimumSize(new java.awt.Dimension(116, 18));
        imagemOriginalBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagemOriginalBotaoActionPerformed(evt);
            }
        });

        Cinza1bitBotao.setBackground(new java.awt.Color(255, 255, 255));
        Quantizadores.add(Cinza1bitBotao);
        Cinza1bitBotao.setText("1bit Cinza");
        Cinza1bitBotao.setActionCommand("botao1bitCinza");
        Cinza1bitBotao.setMaximumSize(new java.awt.Dimension(116, 18));
        Cinza1bitBotao.setMinimumSize(new java.awt.Dimension(116, 18));
        Cinza1bitBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cinza1bitBotaoActionPerformed(evt);
            }
        });

        Cinza2bitBotao.setBackground(new java.awt.Color(255, 255, 255));
        Quantizadores.add(Cinza2bitBotao);
        Cinza2bitBotao.setText("2bit Cinza");
        Cinza2bitBotao.setMaximumSize(new java.awt.Dimension(116, 18));
        Cinza2bitBotao.setMinimumSize(new java.awt.Dimension(116, 18));
        Cinza2bitBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cinza2bitBotaoActionPerformed(evt);
            }
        });

        CMYK1bitBotao.setBackground(new java.awt.Color(255, 255, 255));
        Quantizadores.add(CMYK1bitBotao);
        CMYK1bitBotao.setText("1 bit CMYK");
        CMYK1bitBotao.setMaximumSize(new java.awt.Dimension(116, 18));
        CMYK1bitBotao.setMinimumSize(new java.awt.Dimension(116, 18));
        CMYK1bitBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMYK1bitBotaoActionPerformed(evt);
            }
        });

        CMYK2bitBotao.setBackground(new java.awt.Color(255, 255, 255));
        Quantizadores.add(CMYK2bitBotao);
        CMYK2bitBotao.setText("2 bit CMYK");
        CMYK2bitBotao.setMaximumSize(new java.awt.Dimension(116, 18));
        CMYK2bitBotao.setMinimumSize(new java.awt.Dimension(116, 18));
        CMYK2bitBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMYK2bitBotaoActionPerformed(evt);
            }
        });

        RGB1bitBotao.setBackground(new java.awt.Color(255, 255, 255));
        Quantizadores.add(RGB1bitBotao);
        RGB1bitBotao.setText("1bit RGB");
        RGB1bitBotao.setActionCommand("1bitRGB");
        RGB1bitBotao.setMaximumSize(new java.awt.Dimension(116, 18));
        RGB1bitBotao.setMinimumSize(new java.awt.Dimension(116, 18));
        RGB1bitBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RGB1bitBotaoActionPerformed(evt);
            }
        });

        RGB2bitBotao.setBackground(new java.awt.Color(255, 255, 255));
        Quantizadores.add(RGB2bitBotao);
        RGB2bitBotao.setText("2bit RGB");
        RGB2bitBotao.setActionCommand("2bitRGB");
        RGB2bitBotao.setMaximumSize(new java.awt.Dimension(116, 18));
        RGB2bitBotao.setMinimumSize(new java.awt.Dimension(116, 18));
        RGB2bitBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RGB2bitBotaoActionPerformed(evt);
            }
        });

        coresTabelaVerdeBotao.setBackground(new java.awt.Color(255, 255, 255));
        Quantizadores.add(coresTabelaVerdeBotao);
        coresTabelaVerdeBotao.setText("Tabela de Verde");
        coresTabelaVerdeBotao.setActionCommand("CoresTabelaVerde");
        coresTabelaVerdeBotao.setMaximumSize(new java.awt.Dimension(116, 18));
        coresTabelaVerdeBotao.setMinimumSize(new java.awt.Dimension(116, 18));
        coresTabelaVerdeBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coresTabelaVerdeBotaoActionPerformed(evt);
            }
        });

        CoresGameBoyBotao.setBackground(new java.awt.Color(255, 255, 255));
        Quantizadores.add(CoresGameBoyBotao);
        CoresGameBoyBotao.setText("Cores Game Boy");
        CoresGameBoyBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoresGameBoyBotaoActionPerformed(evt);
            }
        });

        imagemSlider.setBackground(new java.awt.Color(255, 255, 255));
        imagemSlider.setMaximum(8);
        imagemSlider.setMinimum(2);
        imagemSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        imagemSlider.setToolTipText("");
        imagemSlider.setValue(4);
        imagemSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        imagemSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                imagemSliderStateChanged(evt);
            }
        });

        javax.swing.GroupLayout painelFundoLayout = new javax.swing.GroupLayout(painelFundo);
        painelFundo.setLayout(painelFundoLayout);
        painelFundoLayout.setHorizontalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(RGB1bitBotao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RGB2bitBotao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMYK1bitBotao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cinza1bitBotao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagemOriginalBotao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Cinza2bitBotao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CMYK2bitBotao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coresTabelaVerdeBotao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoSelecionarImagem, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoAplicarDithering, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CoresGameBoyBotao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagemSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(quantizador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoSalvarArquivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 1039, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelFundoLayout.setVerticalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelFundoLayout.createSequentialGroup()
                        .addComponent(quantizador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imagemOriginalBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cinza1bitBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cinza2bitBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMYK1bitBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CMYK2bitBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RGB1bitBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RGB2bitBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coresTabelaVerdeBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CoresGameBoyBotao)
                        .addGap(18, 18, 18)
                        .addComponent(botaoSelecionarImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoAplicarDithering, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSalvarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imagemSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 70, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, 1191, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSelecionarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarImagemActionPerformed
       
       selecionadorImagem.showOpenDialog(labelImagem);
       
    }//GEN-LAST:event_botaoSelecionarImagemActionPerformed

    private void selecionadorImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionadorImagemActionPerformed
     
        imagemOriginalBotao.setSelected(true);

        processamentoImagem.setImagemCarregada(
                new ImageIcon(selecionadorImagem.getSelectedFile().getAbsolutePath()));
        
        labelImagem.setIcon(processamentoImagem.imagemCarregada);
        
        labelImagem.setText("");
        imagemSlider.setValue(valorPadraoimagemSlider);
            
    }//GEN-LAST:event_selecionadorImagemActionPerformed

    private void imagemSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_imagemSliderStateChanged
        
        if(processamentoImagem.imagemCarregada != null){
            
            float valorSlider = (imagemSlider.getValue() / 4f);
            
            int alturaImagem = Math.round((valorSlider) * processamentoImagem.imagemCarregada.getIconHeight());
            int larguraImagem = Math.round((valorSlider) * processamentoImagem.imagemCarregada.getIconWidth());
            
            if(alturaImagem == 0 || larguraImagem == 0){
                
                alturaImagem = 1;
                larguraImagem = 1;
                
            }
            
            if(imagemOriginalBotao.isSelected()){
                
                Image imgemTemporaria = processamentoImagem.imagemCarregada.getImage();
                Image novaImagem = imgemTemporaria.getScaledInstance(
                         larguraImagem,alturaImagem, Image.SCALE_SMOOTH);
                labelImagem.setIcon( new ImageIcon(novaImagem) );
                
            }else{
                
                Image novaImagem = processamentoImagem.imagemTemporaria.getScaledInstance(
                     larguraImagem,alturaImagem, Image.SCALE_SMOOTH);
                labelImagem.setIcon( new ImageIcon(novaImagem) );           
            
            }            
        }        
    }//GEN-LAST:event_imagemSliderStateChanged

    private void Cinza1bitBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cinza1bitBotaoActionPerformed
        
        if(processamentoImagem.imagemCarregada != null){
            
            processamentoImagem.quantizaImagem("Cinza1bitBotao");            
            imagemSliderStateChanged(null);
            
        }                
    }//GEN-LAST:event_Cinza1bitBotaoActionPerformed

    private void imagemOriginalBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagemOriginalBotaoActionPerformed
       
        if(processamentoImagem.imagemCarregada != null){
                        
            processamentoImagem.quantizaImagem("imagemOriginalBotao");
            imagemSliderStateChanged(null);
            
        }      
    }//GEN-LAST:event_imagemOriginalBotaoActionPerformed

    private void Cinza2bitBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cinza2bitBotaoActionPerformed
        
        if(processamentoImagem.imagemCarregada != null){
            
            processamentoImagem.quantizaImagem("Cinza2bitBotao");
            imagemSliderStateChanged(null);
            
        }
        
    }//GEN-LAST:event_Cinza2bitBotaoActionPerformed

    private void CMYK1bitBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMYK1bitBotaoActionPerformed
        
        if(processamentoImagem.imagemCarregada != null){
            
            processamentoImagem.quantizaImagem("CMYK1bitBotao");
            imagemSliderStateChanged(null);
            
        }
    }//GEN-LAST:event_CMYK1bitBotaoActionPerformed

    private void CMYK2bitBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CMYK2bitBotaoActionPerformed
        
        if(processamentoImagem.imagemCarregada != null){
            
            processamentoImagem.quantizaImagem("CMYK2bitBotao");
            imagemSliderStateChanged(null);
            
        }
    }//GEN-LAST:event_CMYK2bitBotaoActionPerformed

    private void RGB1bitBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RGB1bitBotaoActionPerformed
        
        if(processamentoImagem.imagemCarregada != null){
            
            processamentoImagem.quantizaImagem("RGB1bitBotao");
            imagemSliderStateChanged(null);
            
        }
    }//GEN-LAST:event_RGB1bitBotaoActionPerformed

    private void RGB2bitBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RGB2bitBotaoActionPerformed
        
        if(processamentoImagem.imagemCarregada != null){
            
            processamentoImagem.quantizaImagem("RGB2bitBotao");
            imagemSliderStateChanged(null);
            
        }
    }//GEN-LAST:event_RGB2bitBotaoActionPerformed

    private void coresTabelaVerdeBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coresTabelaVerdeBotaoActionPerformed
        
        if(processamentoImagem.imagemCarregada != null){
            
            processamentoImagem.quantizaImagem("coresTabelaVerde");
            imagemSliderStateChanged(null);
            
        }
    }//GEN-LAST:event_coresTabelaVerdeBotaoActionPerformed

    private void botaoAplicarDitheringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAplicarDitheringActionPerformed
        
        if(processamentoImagem.imagemCarregada != null){
            
            //Quando clica para aplicar dithering e não tem nenhuma
            //opção ativada ele vai automaticamente para a primeira 
            //opção que é "Cinza1bitBotao"
            if(imagemOriginalBotao.isSelected()){
            
                Cinza1bitBotao.setSelected(true);
                processamentoImagem.processaDithering("Cinza1bitBotao");
                imagemSliderStateChanged(null);
                
            }else if(Cinza1bitBotao.isSelected()){
            
                Cinza1bitBotao.setSelected(true);
                processamentoImagem.processaDithering("Cinza1bitBotao");
                imagemSliderStateChanged(null);
                
            }else if(Cinza2bitBotao.isSelected()){
            
                Cinza2bitBotao.setSelected(true);
                processamentoImagem.processaDithering("Cinza2bitBotao");
                imagemSliderStateChanged(null);
                
            }else if(CMYK1bitBotao.isSelected()){
            
                CMYK1bitBotao.setSelected(true);
                processamentoImagem.processaDithering("CMYK1bitBotao");
                imagemSliderStateChanged(null);
                
            }else if(CMYK2bitBotao.isSelected()){
            
                CMYK2bitBotao.setSelected(true);
                processamentoImagem.processaDithering("CMYK2bitBotao");
                imagemSliderStateChanged(null);
                
            }else if(RGB1bitBotao.isSelected()){
            
                RGB1bitBotao.setSelected(true);
                processamentoImagem.processaDithering("RGB1bitBotao");
                imagemSliderStateChanged(null);
                
            }else if(RGB2bitBotao.isSelected()){
            
                RGB2bitBotao.setSelected(true);
                processamentoImagem.processaDithering("RGB2bitBotao");
                imagemSliderStateChanged(null);
                
            }else if(coresTabelaVerdeBotao.isSelected()){
            
                coresTabelaVerdeBotao.setSelected(true);
                processamentoImagem.processaDithering("coresTabelaVerde");
                imagemSliderStateChanged(null);
                
            }else if(CoresGameBoyBotao.isSelected()){
                
                CoresGameBoyBotao.setSelected(true);
                processamentoImagem.processaDithering("coresGameBoyBotao");
                imagemSliderStateChanged(null);
                
            }            
        }        
    }//GEN-LAST:event_botaoAplicarDitheringActionPerformed

    private void CoresGameBoyBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoresGameBoyBotaoActionPerformed
        
        if(processamentoImagem.imagemCarregada != null){
            
            processamentoImagem.quantizaImagem("coresGameBoyBotao");
            imagemSliderStateChanged(null);
            
        }
    }//GEN-LAST:event_CoresGameBoyBotaoActionPerformed

    private void botaoSalvarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarArquivoActionPerformed
        
        if(processamentoImagem.imagemCarregada != null &&
                processamentoImagem.imagemTemporaria != null){
                         
            int nomeArquivoQueVaiSerSalvo = 
                    SalvarArquivoFileChooser.showSaveDialog(labelImagem);
            
            if (nomeArquivoQueVaiSerSalvo == SalvarArquivoFileChooser.APPROVE_OPTION) {
                                
                BufferedImage img = processamentoImagem.imagemTemporaria;
                File arquivoParaSerSalvo = new File(
                        SalvarArquivoFileChooser.getSelectedFile().toString() + ".png");
                
                try {
                    ImageIO.write(img, "PNG", arquivoParaSerSalvo);

                } catch (IOException ex) {
                    
                    System.err.println("Não salvou o arquivo");
                    
                }                
            }            
        }        
    }//GEN-LAST:event_botaoSalvarArquivoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton CMYK1bitBotao;
    private javax.swing.JRadioButton CMYK2bitBotao;
    private javax.swing.JRadioButton Cinza1bitBotao;
    private javax.swing.JRadioButton Cinza2bitBotao;
    private javax.swing.JRadioButton CoresGameBoyBotao;
    private javax.swing.ButtonGroup Quantizadores;
    private javax.swing.JRadioButton RGB1bitBotao;
    private javax.swing.JRadioButton RGB2bitBotao;
    private javax.swing.JFileChooser SalvarArquivoFileChooser;
    private javax.swing.JButton botaoAplicarDithering;
    private javax.swing.JButton botaoSalvarArquivo;
    private javax.swing.JButton botaoSelecionarImagem;
    private javax.swing.JRadioButton coresTabelaVerdeBotao;
    private javax.swing.JRadioButton imagemOriginalBotao;
    private javax.swing.JSlider imagemSlider;
    private javax.swing.JLabel labelImagem;
    private javax.swing.JPanel painelFundo;
    private javax.swing.JLabel quantizador;
    public javax.swing.JFileChooser selecionadorImagem;
    // End of variables declaration//GEN-END:variables
}
