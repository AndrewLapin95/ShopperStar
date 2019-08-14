import React from 'react';
import axios from "axios";

class DetailsContent extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            quantity: 0
        };

        this.getAvailability = this.getAvailability.bind(this);
        this.getPrices = this.getPrices.bind(this);
        this.incrementQuantity = this.incrementQuantity.bind(this);
        this.decrementQuantity = this.decrementQuantity.bind(this);
    }

    getAvailability() {
        if (this.props.availability == "IN_STOCK") {
            return "In Stock";
        } else {
            return "Unavailable";
        }
    }

    getPrices() {
        
        if (this.props.oldPrice == this.props.newPrice) {
            return <div className="details_price">${this.props.newPrice}</div>;
        } else {
            return <span><div className="details_discount">${this.props.oldPrice}</div><div className="details_price">${this.props.newPrice}</div></span>;
        }

    }

    incrementQuantity() {
        this.setState({
            quantity: this.state.quantity + 1
        });
    }

    decrementQuantity() {

        if (this.state.quantity > 0) {
            this.setState({
                quantity: this.state.quantity - 1
            });
        }
    }

    render() {

        return (
            <div className="details_content">
                <div className="details_name">{this.props.title}</div>
                {this.getPrices()}

                <div className="in_stock_container">
                    <div className="availability">Availability:</div>
                    <span>{this.getAvailability()}</span>
                </div>
                <div className="details_text">
                    <p>{this.props.description}</p>
                </div>

                <div className="product_quantity_container">
                    <div className="product_quantity clearfix">
                        <span>Qty</span>
                        <input id="quantity_input" type="text" pattern="[0-9]*" value={this.state.quantity} onChange={e => this.setState({ quantity: e.target.value })}/>
                        <div className="quantity_buttons">
                            <div id="quantity_inc_button" onClick={this.incrementQuantity} className="quantity_inc quantity_control"><i className="fa fa-chevron-up" aria-hidden="true"></i></div>
                            <div id="quantity_dec_button" onClick={this.decrementQuantity} className="quantity_dec quantity_control"><i className="fa fa-chevron-down" aria-hidden="true"></i></div>
                        </div>
                    </div>
                    <div className="button cart_button"><a href="#">Add to cart</a></div>
                </div>
            </div>
        ); 
    } 
}

class DetailsImage extends React.Component {
    
    constructor(props) {
        
        super(props);

        this.state = {
            activeImage: ""
        };

        this.setAsActive = this.setAsActive.bind(this);
    }

    setAsActive(image) {
        this.setState({
            activeImage: image
        });
    }

    render() {
        
        let curActiveImage = "";
        
        if (this.state.activeImage == "") {
            curActiveImage = this.props.image1;
        } else {
            curActiveImage = this.state.activeImage;
        }

        return (
            <div className="details_image">
                <div className="details_image_large"><img src={curActiveImage} alt="" /></div>
                <div className="details_image_thumbnails d-flex flex-row align-items-start justify-content-between">
                    <div className="details_image_thumbnail" onClick={() => this.setAsActive(this.props.image1)} data-image={this.props.image1}><img src={this.props.image1} alt="" /></div>
                    <div className="details_image_thumbnail" onClick={() => this.setAsActive(this.props.image2)} data-image={this.props.image2}><img src={this.props.image2} alt="" /></div>
                    <div className="details_image_thumbnail" onClick={() => this.setAsActive(this.props.image3)} data-image={this.props.image3}><img src={this.props.image3} alt="" /></div>
                    <div className="details_image_thumbnail" onClick={() => this.setAsActive(this.props.image4)} data-image={this.props.image4}><img src={this.props.image4} alt="" /></div>
                </div>
            </div>            
        );
    }
}

class ProductDetailed extends React.Component { 
    
    constructor(props) {
        super(props);
        
        this.state = {
            product: {
                title: "",
                oldPrice: 0,
                newPrice: 0,
                category: "",
                availability: "",
                images: [
                    { imageUri: "" },
                    { imageUri: "" },
                    { imageUri: "" },
                    { imageUri: "" },
                ],
                description: ""
            }
        }

    }

    async componentDidMount() {

        const response = await axios.get("/api/get-product/" + this.props.match.params.id);

        this.setState({
            product: response.data
        });
    }

    render() {

        return (
            <div className="super_container">
                <div className="product_details">
                    <div className="container">
                        <div className="row details_row">

                            <div className="col-lg-6">
                                <DetailsImage image1={this.state.product.images[0].imageUri}
                                              image2={this.state.product.images[1].imageUri}
                                              image3={this.state.product.images[2].imageUri}
                                              image4={this.state.product.images[3].imageUri} />
                            </div>

                            <div className="col-lg-6">
                                <DetailsContent title={this.state.product.title}
                                                oldPrice={this.state.product.oldPrice}
                                                newPrice={this.state.product.newPrice}
                                                availability={this.state.product.availability}
                                                description={this.state.product.description}/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        ); 
    } 
} 

export default ProductDetailed;