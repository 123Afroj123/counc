public class Array {
    
}
// index.js
const qrcode = require('qrcode-terminal');
const { Client } = require('whatsapp-web.js');
const cron = require('node-cron');

const client = new Client();

client.on('qr', (qr) => {
  qrcode.generate(qr, { small: true }); // Scan this QR in your phone's WhatsApp
});

client.on('ready', () => {
  console.log('Client is ready!');

  // Schedule message: Every day at 9:00 AM
  cron.schedule('0 9 * * *', async () => {
    const number = '91xxxxxxxxxx'; // Replace with your WhatsApp number
    const chatId = number + '@c.us';

    client.sendMessage(chatId, 'Hello! This is your scheduled message.');
    console.log('Message sent!');
  });
});

client.initialize();

