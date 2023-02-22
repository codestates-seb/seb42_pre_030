import create from "zustand";



const useLeftNavStore = create((set) => ({
    showLeftNav: false,
    handleLeftNav: () => set((state) => ({ showLeftNav: !state.showLeftNav })),
}));

const useShareSheetStore = create((set) => ({
    showShareSheet: false,
    handleShareSheet: () => set((state) => ({ showShareSheet: !state.showShareSheet })),
}));

const useErrorMessageStore = create((set) => ({
    errorMessage: "",
    setErrorMessage: (messageContent) => set(() => ({ errorMessage: messageContent })),
}));

const useIsLoginStore = create((set) => ({
    isLogin: false,
    setIsLogin: (loginstate) => set(() => ({ isLogin: loginstate })),
}));

export { useLeftNavStore, useShareSheetStore, useErrorMessageStore, useIsLoginStore };