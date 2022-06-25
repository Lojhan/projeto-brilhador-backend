import { MailerModule } from '@nestjs-modules/mailer';
import { HandlebarsAdapter } from '@nestjs-modules/mailer/dist/adapters/handlebars.adapter';
import { MailerOptions, TransportType } from '@nestjs-modules/mailer/dist/interfaces/mailer-options.interface';
import { Module } from '@nestjs/common';
import { Transport } from '@nestjs/microservices';
import { MailService } from './mail.service';


const options: MailerOptions = {
  transport: {
    host: 'smtp.mandrillapp.com',
    authenticationType: 'login',
    port: 587,
    auth: {
      user: 'viniciuslojhan@gmail.com',
      pass: '123456Ab!',
    },
  },
  template: {
    dir: `${__dirname}/templates`,
    adapter: new HandlebarsAdapter(),
    options: {
      strict: true,
    },
  },
}
@Module({
  imports: [
    // MailerModule.forRoot(options),
  ],
  providers: [MailService],
})
export class MailModule {}
