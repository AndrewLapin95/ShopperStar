import React from 'react';

class UpperLeftPanel extends React.Component {
    render() {
        return (
            <div className="header_extra ml-auto">
                <div className="upper_left_panel">
                    <a href="cart.html">
                        <div><i className="far fa-shopping-cart fa-lg"></i></div>
                        <div>(0)</div>
                    </a>
                    <a href="/auth/google">
                        <div><span><i className="far fa-user fa-lg"></i></span></div>
                    </a>
                </div>
            </div>
        )
    }
}

export default UpperLeftPanel;