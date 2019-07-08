import React from "react"

class ReturnPage extends React.Component {
    render() {
        return (
            <div className="super_container">
                <div class="return_page">

                <div class="row">
                    <div class="col-lg-8 offset-lg-2">
                        <div class="return_content text-center">
                            <div class="return_text">Thank you for shopping with us!</div>
                            <div class="return_form_container">
                                <form action="/" id="return_form" className="return_form">
                                    <button class="return_button trans_200"><span>Continue Shopping</span></button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                </div>
            </div>
        ) 
    }
}

export default ReturnPage;