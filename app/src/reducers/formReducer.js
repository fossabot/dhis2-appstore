import { reducer as formReducer } from "redux-form";
import * as actions from "../constants/actionTypes";

const submittedSuccess = {
    submitted: true,
    submitting: false,
    submitSucceeded: true
};

const submittedError = {
    submitted: true,
    submitting: false,
    submitSucceeded: false,
    submitFailed: true
};

const form = formReducer.plugin({
    imageUpload: (state, action) => {
        switch (action.type) {
            case actions.APP_IMAGES_ADD: {
                return {
                    ...state,
                    submitting: true
                };
            }
            case actions.APP_IMAGES_ADD_SUCCESS: {
                return {
                    ...state,
                    ...submittedSuccess,
                    values: state.initial,
                    anyTouched: false
                };
            }

            case actions.APP_IMAGE_ADD_ERROR: {
                const { fieldIndex, message, file } = action.payload;
                const newUploads = Object.assign(
                    [...state.syncErrors.uploads],
                    {
                        [fieldIndex]: {
                            files: "Failed to upload file: " + message
                        }
                    }
                );
                const newValues = { uploads: [{ files: [file] }] };
                return {
                    ...state,
                    syncErrors: {
                        ...state.syncErrors,
                        uploads: newUploads
                    },
                    values: newValues
                };
            }

            case actions.APP_IMAGES_ADD_ERROR: {
                return {
                    ...state,
                    ...submittedError,
                    anyTouched: true
                };
            }
            default: {
                return state;
            }
        }
    },

    uploadAppForm: (state, action) => {
        switch (action.type) {
            case actions.APP_ADD: {
                return {
                    ...state,
                    submitting: true
                };
            }
            case actions.APP_ADD_SUCCESS: {
                return {
                    ...state,
                    ...submittedSuccess
                };
            }

            case actions.APP_ADD_ERROR: {
                return {
                    ...state,
                    ...submittedError
                };
            }

            default: {
                return state;
            }
        }
    }
});

export default form;
