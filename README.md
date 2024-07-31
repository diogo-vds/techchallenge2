# techchallenge2
Implementacao do 2 desafio da Pos graduacao em Arquitetura e desenvolvimento Java da Fiap

# Sistema de Parquímetro
# Este repositório contém o código-fonte do Sistema de Parquímetro, projetado para lidar com o aumento da demanda de estacionamento em uma cidade turística. O sistema oferece funcionalidades como registro de condutores e veículos, opções flexíveis de pagamento e emissão de recibos.

Visão Geral do Sistema
O novo sistema de parquímetro foi projetado para lidar com a crescente demanda de estacionamento na cidade. Ele oferece funcionalidades como registro de condutores e veículos, controle do tempo estacionado, opções flexíveis de pagamento e emissão de recibos.

Funcionalidades
Registro de Condutores e Veículos
Os condutores podem se registrar no sistema, associando seus dados pessoais, como nome, endereço e informações de contato.
Um condutor pode vincular vários veículos à sua conta, facilitando o gerenciamento de múltiplos veículos.
Registro de Forma de Pagamento
Antes de usar o sistema, o condutor deve registrar sua forma de pagamento preferida, que pode incluir cartão de crédito, débito ou PIX.
A opção PIX só está disponível para períodos de estacionamento fixos.
Opções de Pagamento
Os condutores têm a opção de pagar pelo estacionamento de várias maneiras, incluindo cartão de crédito, débito ou PIX, dependendo da forma de pagamento registrada.
A cobrança é baseada no tempo utilizado; para tempos fixos, o valor total é cobrado independentemente do tempo real utilizado, enquanto para períodos variáveis, a cobrança é por hora completa.
Alertas de Tempo Estacionado
O sistema inclui um recurso de alerta que notifica o condutor quando o tempo de estacionamento está prestes a expirar, no caso de horários fixos.
Para períodos variáveis, o sistema também emite um alerta informando que o sistema estenderá automaticamente o estacionamento por mais uma hora, a menos que o condutor desligue o registro.
Emissão de Recibos
O sistema emite recibos automaticamente sempre que o tempo de estacionamento é encerrado e a cobrança é realizada.
Os recibos fornecem informações detalhadas, incluindo o tempo estacionado, a tarifa aplicada e o valor total pago.
Tecnologias Utilizadas

Java 17
Spring Boot
MongoDB
Swagger

Clone o repositório:
git clone https://github.com/diogo-vds/techchallenge2.git

Copiar código
http://localhost:8080/swagger-ui.html

