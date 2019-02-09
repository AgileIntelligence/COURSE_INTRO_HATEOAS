import React, { Component } from "react";
import AddButton from "./AddButton";
import Capability from "./Capability";
import { connect } from "react-redux";
import { getAllCapabilities } from "../../actions/CapabilityActions";

class Dashboard extends Component {
  componentDidMount() {
    this.props.getAllCapabilities();
  }

  render() {
    return (
      <React.Fragment>
        <AddButton />
        <Capability />
        <Capability />
        <Capability />
      </React.Fragment>
    );
  }
}

export default connect(
  null,
  { getAllCapabilities }
)(Dashboard);
