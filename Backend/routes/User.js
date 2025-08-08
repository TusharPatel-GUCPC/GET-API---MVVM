const express = require('express');
const router = express.Router();
const UserController = require('../controllers/userController');

router.route('/')
    .get(UserController.getAllUsers)
    .post(UserController.createNewUser)
    .put(UserController.updateUser)
    

router.route('/:id')
    .get(UserController.getUser)
    .delete(UserController.deleteUser)

module.exports = router;