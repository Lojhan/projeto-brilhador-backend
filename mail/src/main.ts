import { NestFactory } from '@nestjs/core';
import { SwaggerModule, DocumentBuilder } from '@nestjs/swagger';
import { AppModule } from './app.module';

async function bootstrap() {
  const app = await NestFactory.create(AppModule);

  app.enableCors();

  // setTimeout(() => {
  //   try {
  //     console.log(`[CONNECTING TO RABBITMQ]`)
  //     app.connectMicroservice<any>({
  //       name: 'AUTH_SERVICE',
  //       transport: Transport.TCP,
  //       options: {
  //         urls: ['http://0.0.0.0:5673'],
  //         queue: 'auth_queue',
  //         noAck: false,
  //         queueOptions: {
  //           durable: false,
  //         },
  //       },
  //     });
  //   } catch (e) {
  //     console.log(e)
  //   }
  // }, 10000);

  const config = new DocumentBuilder()
    .setTitle('Auth')
    .setDescription('Auth Api Boilerplate')
    .setVersion('1.0')
    .build();
  const document = SwaggerModule.createDocument(app, config);
  SwaggerModule.setup('api', app, document);
  app.startAllMicroservices();
  await app.listen(3000);
}
bootstrap();
