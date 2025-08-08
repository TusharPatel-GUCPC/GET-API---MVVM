require('dotenv').config();
const express = require('express');
const app = express();
const mongoose = require('mongoose');
const connectDB = require('./config/dbConnect');
const PORT = process.env.PORT || 3500;

connectDB();
app.use(express.json()); // ✅ This parses incoming JSON requests

app.use('/user', require('./routes/User'));

mongoose.connection.once('open', () => {
    console.log('Connected to MongoDB');
    app.listen(PORT, "0.0.0.0", () => console.log(`Server running on port ${PORT}`));
});