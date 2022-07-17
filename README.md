# DsMeta
# SpringBoot + Kotlin Application

[![Build Status](https://app.travis-ci.com/bapadua/ds-meta.svg?branch=main)](https://travis-ci.org/bapadua/ds-meta)
![Skills](https://img.shields.io/badge/Spring-Kotlin-blueviolet?style=plastic&logo=springboot)
![Frontend](https://img.shields.io/badge/React-Typescript-orange?style=plastic&logo=react)

# Treinamento fullstack oferecido pelo canal DevSuperior do dia 11/07/22 a 17/07/22.


Serviço de notificação de vendas via sms, utilizando springboot para o backend
e react com typescript para o frontend... 

Minha versão fiz algumas motificações, utilizando o kotlin para o backend, alterei o tipo do id para UUID(GUID), adicionei uma variavel **TWILIO_ACTIVE]** para 
desativar o twilio para que terceiros **não façam spam e gastem os créditos do trial**, deixando apenas um log da mensagem enviada no console, para ver via cmd
**heroku logs --tail -a nome-do-seu-app**:
<img src='https://user-images.githubusercontent.com/3621327/179404968-8fff2ffa-d8e0-436c-a4fd-9e3fb8c32e3e.png'>

**twilio ativo**:

<img src='https://user-images.githubusercontent.com/3621327/179405001-4fefde3e-ab6f-4898-a8b9-d1ea0d833987.png' width='200' height='450'>

Também adicionei uma verificação da build no **travis-ci.com**, e criei mocks novos no **mockaroo** (https://www.mockaroo.com/)


Canal do professor **Nélio Alves no youtube** - https://www.youtube.com/c/DevSuperior

Site https://devsuperior.com.br

What you'll need

- Java 11+
## Features
- Configure spring rest app
- Configure twilio account to sms https://www.twilio.com
- Mock data with h2 (mockaroo)

Enjoy.

Bruno Pádua

Edit: Comando para subir a branch direto no heroku, o autodeploy do github não funciona com subpastas.
  
heroku -v

heroku login

heroku git:remote -a <nome-do-app>
  
git remote -v
  
**git subtree push --prefix backend heroku main**
