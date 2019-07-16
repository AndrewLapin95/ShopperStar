import React from "react";
import { connect } from 'react-redux';

class Authorization extends React.Component {
    renderContent() {
        if (this.props.auth == null) {
            return <div><span>Loading...</span></div>;
        } else if (this.props.auth == false) {
            return <a href="/auth/google"><div><span><i className="fab fa-google fa-lg"></i></span></div></a>
        } else {
            return <a href="/api/logout"><div><span><i className="far fa-sign-out fa-lg"></i></span></div></a>;
        }
    }

    render() {
        return (
            <span>{this.renderContent()}</span>
        );
    }
}

function mapStateToProps({ auth }) {
    return { auth };
}

export default connect(mapStateToProps)(Authorization);