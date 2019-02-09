import React, { Component } from "react";
import AddButton from "./AddButton";
import Capability from "./Capability";

class Dashboard extends Component {
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

export default Dashboard;
