import { Application } from 'express';

export function addRelativeRoute(app: Application) {
  app.get('/relative', (req, res) => res.send('This route was defined in a file that was included through a relative import!'));
}
