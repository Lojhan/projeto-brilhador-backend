import { MailerService } from '@nestjs-modules/mailer';
import { Injectable } from '@nestjs/common';

@Injectable()
export class MailService {

  constructor(
    // private mailerService: MailerService
    ) {}

  public sendTicketMail(payload: { user: any, ticket: any }) {
    const { user, ticket } = payload;

    const mail = `
      Olá, ${ user.name }!
      Seu ticket foi criado com sucesso!
      Ticket priority: ${ ticket.priority }
      Ticket description: ${ ticket.description }

      Atenciosamente,
      Equipe de Suporte
    `

    console.log(mail);
    // return this.mailerService.sendMail({
    //   to: user.email,
    //   subject: `[${ticket.priority} PRIORITY TICKET] Seu ticket foi criado!`,
    //   template: `${__dirname}/templates/token.template.hbs`,
    //   context: { user, ticket },
    // });
  }
}
