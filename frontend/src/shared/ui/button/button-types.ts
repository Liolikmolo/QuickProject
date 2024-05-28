import { ReactNode } from 'react';

export type ButtonProps = {
	style: 'primary' | 'card' | 'secondary' | 'tertiary';
	children: ReactNode;
};
