import axios from "axios";
import { GET_CAPABILITIES, DELETE_CAPABILITY } from "./ActionTypes";

export const getAllCapabilities = () => async dispatch => {
  try {
    const res = await axios.get("http://localhost:8080/dashboard");
    dispatch({
      type: GET_CAPABILITIES,
      payload: res.data._embedded.capabilityList
    });
  } catch (error) {
    dispatch({
      type: GET_CAPABILITIES,
      payload: []
    });
  }
};

export const deleteCapability = (id, deleteLink) => async dispatch => {
  await axios.delete(deleteLink);
  dispatch({
    type: DELETE_CAPABILITY,
    payload: id
  });
};
