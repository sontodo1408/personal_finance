export const enumToOption = (e) =>
  Object.values(e.E).map((value) => ({
    value,
    label: e.L[value],
  }));
