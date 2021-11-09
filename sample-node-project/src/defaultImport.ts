import { Application } from 'express';

export default function(app: Application) {
  app.get('/default', (req, res) => res.send('This route was defined in a file that was included through a default import!'));
}
