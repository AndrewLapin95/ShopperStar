const express = require('express');
require('./services/passport')

const app = express();

require('./routes/authroutes')(app);

const PORT = 9000;
app.listen(PORT);