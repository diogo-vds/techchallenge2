# techchallenge2
Implementacao do 2 desafio da Pos graduacao em Arquitetura e desenvolvimento Java da Fiap

# Sistema de Parqu�metro
# Este reposit�rio cont�m o c�digo-fonte do Sistema de Parqu�metro, projetado para lidar com o aumento da demanda de estacionamento em uma cidade tur�stica. O sistema oferece funcionalidades como registro de condutores e ve�culos, op��es flex�veis de pagamento e emiss�o de recibos.

Vis�o Geral do Sistema
O novo sistema de parqu�metro foi projetado para lidar com a crescente demanda de estacionamento na cidade. Ele oferece funcionalidades como registro de condutores e ve�culos, controle do tempo estacionado, op��es flex�veis de pagamento e emiss�o de recibos.

Funcionalidades
Registro de Condutores e Ve�culos
Os condutores podem se registrar no sistema, associando seus dados pessoais, como nome, endere�o e informa��es de contato.
Um condutor pode vincular v�rios ve�culos � sua conta, facilitando o gerenciamento de m�ltiplos ve�culos.
Registro de Forma de Pagamento
Antes de usar o sistema, o condutor deve registrar sua forma de pagamento preferida, que pode incluir cart�o de cr�dito, d�bito ou PIX.
A op��o PIX s� est� dispon�vel para per�odos de estacionamento fixos.
Op��es de Pagamento
Os condutores t�m a op��o de pagar pelo estacionamento de v�rias maneiras, incluindo cart�o de cr�dito, d�bito ou PIX, dependendo da forma de pagamento registrada.
A cobran�a � baseada no tempo utilizado; para tempos fixos, o valor total � cobrado independentemente do tempo real utilizado, enquanto para per�odos vari�veis, a cobran�a � por hora completa.
Alertas de Tempo Estacionado
O sistema inclui um recurso de alerta que notifica o condutor quando o tempo de estacionamento est� prestes a expirar, no caso de hor�rios fixos.
Para per�odos vari�veis, o sistema tamb�m emite um alerta informando que o sistema estender� automaticamente o estacionamento por mais uma hora, a menos que o condutor desligue o registro.
Emiss�o de Recibos
O sistema emite recibos automaticamente sempre que o tempo de estacionamento � encerrado e a cobran�a � realizada.
Os recibos fornecem informa��es detalhadas, incluindo o tempo estacionado, a tarifa aplicada e o valor total pago.
Tecnologias Utilizadas

Java 17
Spring Boot
MongoDB
Swagger

Clone o reposit�rio:
git clone https://github.com/diogo-vds/techchallenge2.git

Copiar c�digo
http://localhost:8080/swagger-ui.html

