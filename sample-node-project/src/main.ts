import express from 'express';
import { addRelativeRoute } from './relativeImport';
import addDefaultRoute from './defaultImport';

const app = express();

app.get('/', (req, res) => res.send('Hello World!'));
addRelativeRoute(app);
addDefaultRoute(app);

app.listen(3000, () => console.log('Listening on 3000.'));
