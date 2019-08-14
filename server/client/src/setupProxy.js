const proxy = require('http-proxy-middleware')

module.exports = app => {
    app.use(proxy("/api/subscribe", { target: "http://localhost:8081" }));
    app.use(proxy("/api/save-contact", { target: "http://localhost:8081" }));
    app.use(proxy("/api/create-cart", { target: "http://localhost:8082" }));
    app.use(proxy("/api/get-cart", { target: "http://localhost:8082" }));
    app.use(proxy("/api/get-product", { target: "http://localhost:8084" }));
    app.use(proxy("/api/get-products", { target: "http://localhost:8085" }));
    app.use(proxy("/api/get-products-by-category", { target: "http://localhost:8085" }));
    app.use(proxy("/api/get-products-by-title", { target: "http://localhost:8085" }));
    app.use(proxy("/api/search-products", { target: "http://localhost:8085" }));
    app.use(proxy("/auth/google", { target: "http://localhost:9000" }));
    app.use(proxy("/api/current_user", { target: "http://localhost:9000" }));
};