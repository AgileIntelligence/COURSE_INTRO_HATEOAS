import axios from "axios";
import { GET_CAPABILITIES, DELETE_CAPABILITY } from "./ActionTypes";

export const getAllCapabilities = () => async dispatch => {
  const res = await axios.get("http://localhost:8080/dashboard");

  dispatch({
    type: GET_CAPABILITIES,
    payload: res.data._embedded.capabilityList
  });
};

export const deleteCapability = (id, deleteLink) => async dispatch => {
  await axios.delete(deleteLink);
  dispatch({
    type: DELETE_CAPABILITY,
    payload: id
  });
};
