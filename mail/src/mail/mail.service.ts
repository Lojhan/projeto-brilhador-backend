import { MailerService } from '@nestjs-modules/mailer';
import { Injectable } from '@nestjs/common';
import { User } from '@prisma/client';

@Injectable()
export class MailService {

  constructor(private mailerService: MailerService) {}

  async sendTokenMail(user: User) {
    return this.mailerService.sendMail({
      to: user.email,
      subject: 'Your Sign In Token',
      template: `${__dirname}/templates/token.template.hbs`,
      context: { user },
    });
  }

  public sendTicketMail(payload: { user: any, ticket: any }) {
    const { user, ticket } = payload;
    return this.mailerService.sendMail({
      to: user.email,
      subject: 'Seu ticket foi criado!',
      template: `${__dirname}/templates/token.template.hbs`,
      context: { user },
    });
  }
}
