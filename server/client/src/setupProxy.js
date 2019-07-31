const proxy = require('http-proxy-middleware')

module.exports = app => {
    app.use(proxy("/api/subscribe", { target: "http://localhost:8081" }));
    app.use(proxy("/api/save-contact", { target: "http://localhost:8081" }));
    app.use(proxy("/auth/google", { target: "http://localhost:9000" }));
    app.use(proxy("/api/current_user", { target: "http://localhost:9000" }));
};