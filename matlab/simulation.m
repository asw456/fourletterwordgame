% SIMULATION

clear all
close all
clc

dictionary_name = 'letters_5.txt';

M = 1000;

guesses = zeros(M,1);

for i = 1 : M
    
    clc
    fprintf('SIMULATION : %3i',i)
    
    guesses(i) = mastermind(dictionary_name);
    
end

guesses

mean(guesses)
std(guesses)

figure('Name','Guesses')
axes('fontsize',12)
hold on
grid on
box on
hist(guesses,100)
title('Number of Guesses to find the 5 Letter Word')
xlabel('number of guesses')
ylabel('frequencies')

save('guesses_workspace.mat')